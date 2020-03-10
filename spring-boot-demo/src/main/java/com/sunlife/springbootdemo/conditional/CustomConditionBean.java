package com.sunlife.springbootdemo.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(value = CustomCondition.class)
public class CustomConditionBean {
}
