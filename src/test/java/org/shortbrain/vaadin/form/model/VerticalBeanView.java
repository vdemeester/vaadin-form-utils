package org.shortbrain.vaadin.form.model;

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
        aStringField.setCaption("a String");
        anIntegerField = new TextField();
        anIntegerField.setCaption("an Integer");
        aDoubleField = new TextField();
        aDoubleField.setCaption("a Double");
        
        aValueOfField = new ComboBox();
        aValueOfField.setCaption("A value of");
        aListField = new ListSelect();
        aListField.setCaption("A list of value from");
        
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

    public TextField getAnIntegerField() {
        return anIntegerField;
    }

    public void setAnIntegerField(TextField anIntegerField) {
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

    public ListSelect getaListfield() {
        return aListField;
    }

    public void setaListfield(ListSelect aListfield) {
        this.aListField = aListfield;
    }

}
