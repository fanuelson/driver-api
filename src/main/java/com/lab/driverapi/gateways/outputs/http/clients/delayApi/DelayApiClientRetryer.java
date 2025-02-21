package com.lab.driverapi.gateways.outputs.http.clients.delayApi;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DelayApiClientRetryer implements Retryer {

  private final long maxAttempts;
  private final long waitDuration;
  private long currentAttempts;

  DelayApiClientRetryer() {
    this.maxAttempts = 5;
    this.waitDuration = 1000;
    this.currentAttempts = 1;
  }

  @Override
  public void continueOrPropagate(RetryableException e) {
    log.warn(
        "Executing Retryer, exception: {}, Attempts: {}, MaxAttemps: {}",
        e.getMessage(),
        currentAttempts,
        maxAttempts);
    if (currentAttempts++ >= maxAttempts) {
      throw e;
    }
    try {
      Thread.sleep(this.waitDuration);
    } catch (InterruptedException ignored) {
      throw e;
    }
  }

  @Override
  public Retryer clone() {
    return new DelayApiClientRetryer();
  }
}
