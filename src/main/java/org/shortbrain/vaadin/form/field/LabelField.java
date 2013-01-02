package org.shortbrain.vaadin.form.field;

import java.util.Collection;

import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.Field;
import com.vaadin.ui.Label;
import com.vaadin.ui.Component.Focusable;

/**
 * A {@link Label} that is seen as a {@link Field} (obviously read-only).
 * 
 * As it is read-only, a lot of {@link Field} stuff here is dumb.
 * 
 * @author Vincent Demeester <vincent+git@demeester.fr>
 * 
 */
public class LabelField extends Label implements Field, Focusable {

    private int tabIndex = 0;

    @Override
    public boolean isInvalidCommitted() {
        return false;
    }

    @Override
    public void setInvalidCommitted(boolean isCommitted) {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public void commit() throws SourceException, InvalidValueException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public void discard() throws SourceException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public boolean isWriteThrough() {
        // Do nothing, read-only field, never changing.
        return false;
    }

    @Override
    public void setWriteThrough(boolean writeThrough) throws SourceException, InvalidValueException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public boolean isReadThrough() {
        // Do nothing, read-only field, never changing.
        return false;
    }

    @Override
    public void setReadThrough(boolean readThrough) throws SourceException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public boolean isModified() {
        // Do nothing, read-only field, never changing.
        return false;
    }

    @Override
    public void addValidator(Validator validator) {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public void removeValidator(Validator validator) {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public Collection<Validator> getValidators() {
        // Do nothing, read-only field, never changing.
        return null;
    }

    @Override
    public boolean isValid() {
        // Do nothing, read-only field, never changing.
        return true;
    }

    @Override
    public void validate() throws InvalidValueException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public boolean isInvalidAllowed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setInvalidAllowed(boolean invalidValueAllowed) throws UnsupportedOperationException {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public void focus() {
        super.focus();
    }

    @Override
    public int getTabIndex() {
        return tabIndex;
    }

    @Override
    public void setTabIndex(int tabIndex) {
        this.tabIndex = tabIndex;
    }

    @Override
    public boolean isRequired() {
        return false;
    }

    @Override
    public void setRequired(boolean required) {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public void setRequiredError(String requiredMessage) {
        // Do nothing, read-only field, never changing.
    }

    @Override
    public String getRequiredError() {
        // Do nothing, read-only field, never changing.
        return null;
    }
}
