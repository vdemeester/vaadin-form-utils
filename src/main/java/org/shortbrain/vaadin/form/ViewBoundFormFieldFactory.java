package org.shortbrain.vaadin.form;

import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.Field;
import com.vaadin.ui.FieldFactory;
import com.vaadin.ui.FormFieldFactory;

/**
 * {@link FormFieldFactory} implementation used for {@link ViewBoundForm}. It takes an algorithm to get the fields from the view, add some
 * stuff and options if needed (containers, …).
 * 
 * @author Vincent Demeester <vincent@shortbrain.org>
 * 
 */
public class ViewBoundFormFieldFactory implements FormFieldFactory {

    private static final long serialVersionUID = -676197212496028316L;

    /**
     * Creates a {@link ViewBoundFormFieldFactory} with the propert
     */
    public ViewBoundFormFieldFactory() {
        
    }
    
    @Override
    public Field createField(Item item, Object propertyId, Component uiContext) {
        // TODO Auto-generated method stub
        return null;
    }

}
