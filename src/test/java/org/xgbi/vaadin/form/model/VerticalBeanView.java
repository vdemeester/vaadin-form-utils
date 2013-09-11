package org.xgbi.vaadin.form.model;

import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * {@link VerticalLayout} view for the {@link Bean} form.
 * 
 * @author Vincent Demeester <vincent@shortbrain.org>
 * 
 */
public class VerticalBeanView extends VerticalLayout {

    private TextField aStringField;
    private TextField anIntegerField;
    private TextField aDoubleField;

    private ComboBox aValueOfField;
    private ListSelect aListField;

    public VerticalBeanView() {
        aStringField = new TextField();
        aStringField.setCaption("A String");
        anIntegerField = new TextField();
        anIntegerField.setCaption("An Integer");
        aDoubleField = new TextField();
        aDoubleField.setCaption("A Double");
        
        aValueOfField = new ComboBox();
        aValueOfField.setCaption("A value of");
        aValueOfField.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
        aValueOfField.setItemCaptionPropertyId("value");
        aListField = new ListSelect();
        aListField.setCaption("A list of value from");
        aListField.setMultiSelect(true);
        aListField.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);
        aListField.setItemCaptionPropertyId("value");
        
        this.addComponent(aStringField);
        this.addComponent(anIntegerField);
        this.addComponent(aDoubleField);
        this.addComponent(aValueOfField);
        this.addComponent(aListField);
    }

    public TextField getaStringField() {
        return aStringField;
    }

    public void setaStringField(TextField aStringField) {
        this.aStringField = aStringField;
    }

    public TextField getanIntegerField() {
        return anIntegerField;
    }

    public void setanIntegerField(TextField anIntegerField) {
        this.anIntegerField = anIntegerField;
    }

    public TextField getaDoubleField() {
        return aDoubleField;
    }

    public void setaDoubleField(TextField aDoubleField) {
        this.aDoubleField = aDoubleField;
    }

    public ComboBox getaValueOfField() {
        return aValueOfField;
    }

    public void setaValueOfField(ComboBox aValueOfField) {
        this.aValueOfField = aValueOfField;
    }

    public ListSelect getaListField() {
        return aListField;
    }

    public void setaListField(ListSelect aListfield) {
        this.aListField = aListfield;
    }

}
