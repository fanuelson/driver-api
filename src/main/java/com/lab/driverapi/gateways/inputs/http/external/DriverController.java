package com.lab.driverapi.gateways.inputs.http.external;

import com.lab.driverapi.gateways.inputs.http.mappers.DriverResourceMapper;
import com.lab.driverapi.gateways.inputs.http.resources.requests.DriverRequest;
import com.lab.driverapi.gateways.inputs.http.resources.responses.DriverResponse;
import com.lab.driverapi.usecases.CreateDriverUseCase;
import com.lab.driverapi.usecases.DeleteDriverUseCase;
import com.lab.driverapi.usecases.GetDriverByIdUseCase;
import com.lab.driverapi.usecases.SendDriverCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drivers")
public class DriverController {

  private final CreateDriverUseCase createDriverUseCase;
  private final GetDriverByIdUseCase getDriverByIdUseCase;
  private final DeleteDriverUseCase deleteDriverUseCase;
  private final SendDriverCreateUseCase sendDriverCreateUseCase;

  private final DriverResourceMapper driverResourceMapper;

  @GetMapping("/{id}")
  public ResponseEntity<DriverResponse> getById(@PathVariable() final String id) {
    val driver = getDriverByIdUseCase.execute(id);
    return ResponseEntity.ok(driverResourceMapper.toResponse(driver));
  }

  @PostMapping()
  public ResponseEntity<DriverResponse> create(@RequestBody() final DriverRequest driverRequest) {
    val driver = createDriverUseCase.execute(driverResourceMapper.toDomain(driverRequest));
    return ResponseEntity.ok(driverResourceMapper.toResponse(driver));
  }

  @PostMapping("/kafka")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void sendDriverCreated(@RequestBody() final DriverRequest driverRequest) {
    sendDriverCreateUseCase.execute(driverResourceMapper.toDomain(driverRequest));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable() final String id) {
    deleteDriverUseCase.execute(id);
  }
}
