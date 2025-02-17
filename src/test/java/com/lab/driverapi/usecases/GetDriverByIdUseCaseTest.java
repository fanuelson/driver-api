package com.lab.driverapi.usecases;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.lab.driverapi.builders.DriverBuilder;
import com.lab.driverapi.common.BaseTest;
import com.lab.driverapi.exceptions.DriverNotFoundException;
import com.lab.driverapi.gateways.outputs.mongodb.DriverDataGateway;
import java.util.Optional;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class GetDriverByIdUseCaseTest extends BaseTest {

  @InjectMocks private GetDriverByIdUseCase getDriverByIdUseCase;

  @Mock private DriverDataGateway driverDataGateway;

  @Test
  void shouldThrowNotFoundWhenInexistentDriver() {
    when(driverDataGateway.findById(any(String.class))).thenReturn(Optional.empty());

    assertThrows(DriverNotFoundException.class, () -> getDriverByIdUseCase.execute("any id"));
  }

  @Test
  void shouldReturnDriverIfExists() {
    val expectedDriver = DriverBuilder.VALID();

    when(driverDataGateway.findById("abc")).thenReturn(Optional.of(expectedDriver));

    val driver = getDriverByIdUseCase.execute("abc");

    assertThat(driver).usingRecursiveComparison().isEqualTo(expectedDriver);
  }
}
