package com.nyxei.pollingus.domain.templates;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyxei.pollingus.domain.templates.type.ComponentType;

/**
 * The type Body component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyComponent extends Component<BodyComponent> {


    /**
     * Instantiates a new Body component.
     */
    public BodyComponent() {
        super(ComponentType.BODY);
    }
}
