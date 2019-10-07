package io.qunhao.okr.controller;

import io.qunhao.okr.entity.OkrEntity;
import io.qunhao.okr.repo.OkrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/okr")
public class OkrController {
    @Autowired
    OkrRepo okrRepo;


    @GetMapping("/{id}")
    public OkrEntity getOkr(@PathVariable Long id) {
        return okrRepo.findById(id).orElse(null);
    }

    @GetMapping("/findByOwnerId")
    public List<OkrEntity> findByOwnerId(@RequestParam Long ownerId) {
        return okrRepo.findByOwnerId(ownerId);
    }
}
