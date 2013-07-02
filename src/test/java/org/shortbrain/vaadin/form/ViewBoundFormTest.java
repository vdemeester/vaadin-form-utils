package org.shortbrain.vaadin.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.shortbrain.vaadin.container.ContainerFactory;
import static org.shortbrain.vaadin.container.ContainerFactory.getByGetters;
import org.shortbrain.vaadin.form.model.Bean;
import org.shortbrain.vaadin.form.model.VerticalBeanView;

import com.google.web.bindery.requestfactory.shared.SkipInterfaceValidation;
import com.vaadin.data.Container;
import com.vaadin.data.Container.Filterable;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(BlockJUnit4ClassRunner.class)
public class ViewBoundFormTest {
    
    private static final int NB_BEANS = 10;
    private static final int NB_VALUES = 20;
    private static final int NB_LISTS = 20;

    ContainerFactory<Bean> beanContainerFactory;
    Container container;
    Map<Object, Container> propertyDataSource;

    @Before
    public void setUp() {
        // Set up container
        List<Bean> beans = new ArrayList<Bean>();
        for (int i = 0; i < NB_BEANS; i++) {
            Bean bean = new Bean();
            bean.setaString("str" + i);
            bean.setanInteger(i);
            bean.setaDouble(i * 1.0);
            bean.setaValueOf("valueOf" + i);
            bean.setaList(Arrays.asList(new String[] { "0-" + i, "1-" + i, "2-" + i, "3-" + i, "4-" + i }));
            beans.add(bean);
        }
        beanContainerFactory = getByGetters(Bean.class);
        container = beanContainerFactory.getContainerFromCollection(beans, Filterable.class);

        // Set up propertyDataSource
        propertyDataSource = new HashMap<Object, Container>();
        Container values = new IndexedContainer();
        values.addContainerProperty("value", String.class, null);
        values.addContainerProperty("number", Integer.class, null);
        for (int j = 0; j < NB_VALUES; j++) {
            Object itemId = values.addItem();
            values.getContainerProperty(itemId, "number").setValue(j);
            values.getContainerProperty(itemId, "value").setValue("valueOf" + j);
        }
        propertyDataSource.put("aValueOf", values);
        Container lists = new IndexedContainer();
        lists.addContainerProperty("value", String.class, null);
        lists.addContainerProperty("number", Integer.class, null);
        for (int j = 0; j < NB_LISTS; j++) {
            Object itemId = lists.addItem();
            lists.getContainerProperty(itemId, "number").setValue(j);
            lists.getContainerProperty(itemId, "value").setValue("1-" + j);
        }
        propertyDataSource.put("aList", lists);
    }

    @After
    public void tearDown() {
        // Clean everything
        container.removeAllItems();
        container = null;
        propertyDataSource.clear();
        propertyDataSource = null;
        beanContainerFactory = null;
    }

    /**
     * Test with null reference.
     */
    @Test
    public void testNull() {
        try {
            new ViewBoundForm((ComponentContainer) null);
            fail("should throw an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("layout cannot be null", e.getMessage());
        }
        try {
            new ViewBoundForm((Map<Object, Container>) null);
            fail("should throw an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("propertyDataSource cannot be null", e.getMessage());
        }
        try {
            new ViewBoundForm(null, null);
            fail("should throw an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertEquals("propertyDataSource cannot be null", e.getMessage());
        }
    }

    public void testSimple() {
        VerticalBeanView view = new VerticalBeanView();
        ViewBoundForm viewBoundForm = new ViewBoundForm(propertyDataSource);
        viewBoundForm.setContent(view);
        for (int i = 0; i < 1; i++) {
            viewBoundForm.setItemDataSource(container.getItem(1 + i));
            validate(viewBoundForm, i);
        }
    }

    private void validate(ViewBoundForm form, int i) {
        validateField(form, "aString", "A String", String.class, "str" + i, null);
        validateField(form, "anInteger", "An Integer", String.class, ""+i, null);
        validateField(form, "aDouble", "A Double", String.class, ""+(i + 0.0d), null);
        validateField(form, "aValueOf", "A value of", Object.class, "valueOf" + i, propertyDataSource.get("values"));
        validateField(form, "aList", "A list of value from", Set.class, Arrays.asList(new String[] { "0-" + i, "1-" + i, "2-" + i, "3-" + i, "4-" + i }), propertyDataSource.get("lists"));
    }

    private static void validateField(ViewBoundForm form, Object propertyId, String caption, Class<?> type, Object value, Container dataSource) {
        Field f = form.getField(propertyId);
        assertEquals(caption, f.getCaption());
        assertEquals(type, f.getType());
        if (f.getValue() instanceof Collection<?>) {
            assertCollection((Collection) value, (Collection) f.getValue());
        } else {
            assertEquals(value, f.getValue());
        }
        if (dataSource != null && dataSource.size() > 0 && f instanceof Container.Viewer) {
            Container.Viewer viewer = (Container.Viewer) f;
            assertEquals(dataSource, viewer.getContainerDataSource());
        }
    }

    private static void assertCollection(Collection<?> expected, Collection<?> actual) {
        assertEquals(expected.size(), actual.size());
        for (Object object : expected) {
            if (actual.contains(object)) {
                assertTrue(true);
            } else {
                fail("expected object [" + object + "] is not present in actual");
            }
        }
    }

}
