package org.example.devices;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


public interface Shelter {

    void shelterOn();

    void shelterOff();
}
