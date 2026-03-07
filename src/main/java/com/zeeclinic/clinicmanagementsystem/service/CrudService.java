package com.zeeclinic.clinicmanagementsystem.service;

import java.util.List;
import java.util.UUID;

public interface CrudService<Req, Res> {
    Req create(Req obj);
    List<Res> findAll();
    Res findById(UUID id);
    Res update(UUID id, Req request);
}
