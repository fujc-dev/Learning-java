package com.tuling.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/10/12 15:39
 */
public class MyCondition implements Condition {
    /**
     * Determine if the condition matches.
     *
     * @param context  the condition context
     * @param metadata metadata of the {@link AnnotationMetadata class}
     *                 or {@link MethodMetadata method} being checked
     * @return {@code true} if the condition matches and the component can be registered,
     * or {@code false} to veto the annotated component's registration
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return  metadata.isAnnotated("org.springframework.context.annotation.Configuration");
    }
}
