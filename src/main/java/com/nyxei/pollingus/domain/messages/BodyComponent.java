package com.nyxei.pollingus.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyxei.pollingus.domain.Component;
import com.nyxei.pollingus.domain.messages.type.ComponentType;

import java.awt.*;


/**
 * The type Body component, to send template messages
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyComponent extends Component<BodyComponent> {


    /**
     * Instantiates a new Body component, to send template messages
     */
    public BodyComponent(SystemColor text) {
        super(ComponentType.BODY);
    }
}
