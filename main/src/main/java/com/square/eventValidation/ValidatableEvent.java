package com.square.eventValidation;

import com.square.events.Event;

public interface ValidatableEvent extends Event {
    ValidationResult validate();
}
