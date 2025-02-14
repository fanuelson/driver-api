package com.lab.driverapi.utils;

import org.apache.commons.codec.digest.MurmurHash3;

public class KafkaKeyGeneratorUtils {
  public static String generateKey(String input) {
    int hash = MurmurHash3.hash32x86(input.getBytes()); // Gera um hash determinístico
    return String.valueOf(hash);
  }
}
