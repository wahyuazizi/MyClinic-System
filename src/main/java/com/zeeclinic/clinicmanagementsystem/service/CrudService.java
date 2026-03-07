package com.zeeclinic.clinicmanagementsystem.service;

import java.util.List;
import java.util.UUID;

public interface CrudService<Req, Res> {
    Res create(Req requestPayload);
    List<Res> findAll();
    Res findById(UUID id);
    Res update(UUID id, Req request);
}
