package org.shortbrain.vaadin.form.model;

import java.util.List;

import org.shortbrain.vaadin.form.ViewBoundForm;

/**
 * This is a simple class that will be used to test {@link ViewBoundForm} and stuff.
 * 
 * @author Vincent Demeester<vincent+git@demeester.fr>
 * 
 */
public class Bean {

    // Simple properties
    private String aString;
    private Integer anInteger;
    private Double aDouble;

    // Complex properties
    // Should be represented as a Multi-Select
    private List<String> aList;
    // Might be represented as a Select.
    private String aValueOf;

    public String getaString() {
        return aString;
    }

    public void setaString(String aString) {
        this.aString = aString;
    }

    public Integer getAnInteger() {
        return anInteger;
    }

    public void setAnInteger(Integer anInteger) {
        this.anInteger = anInteger;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public void setaDouble(Double aDouble) {
        this.aDouble = aDouble;
    }

    public List<String> getaList() {
        return aList;
    }

    public void setaList(List<String> aList) {
        this.aList = aList;
    }

    public String getaValueOf() {
        return aValueOf;
    }

    public void setaValueOf(String aValueOf) {
        this.aValueOf = aValueOf;
    }

}
