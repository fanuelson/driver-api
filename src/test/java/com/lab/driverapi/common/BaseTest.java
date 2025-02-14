package com.lab.driverapi.common;

import lombok.val;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseTest {

  @Test
  void shouldSayHello() {
    val value = "hello";
    val expected = "hello";
    Assertions.assertEquals(expected, value);
  }
}
