package com.bank.Controlers;

import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Repository.ED807EntityRepository;
import com.bank.Service.ED807Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;



@RestController
@RequestMapping("/Delete")
@Tag(name = "DeleteController", description = "Контроллер для удаления сущностей в бд")
@SecurityRequirement(name = "basicAuth")
public class DeleteController {

    @Autowired
    private ED807EntityRepository ed807EntityRepository;

    @Autowired
    private ED807Service ed807Service;

    @DeleteMapping("/ed807")
    @Operation(
            summary = "Удаление экземпляра ed807 gj шв",
            description = "Удаление экземпляра ed807 и всех связанных с ним сущностей"
    )
    public ResponseEntity<Void> deleteById(@RequestParam BigInteger id) {
        boolean isDeleted = ed807Service.deletByid(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/all")
    @Operation(
            summary = "Удаление всего",
            description = "Позволяет удалить все из бд связанное с ed807"
    )
    public ResponseEntity<Void> deleteAll() {
        boolean isDeleted = ed807Service.deleteAll();
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/bic")
    @Operation(
            summary = "Удаляет bic",
            description = "Передается 2 параметра, первый BIC, который надо удалить, второй - id ed807 у которой надо удалить "
    )
    public ResponseEntity<Void> deleteBICbyBIC(@RequestParam String BIC, @RequestParam BigInteger EDID){
        boolean isDeleted = ed807Service.deleteBicByBic(BIC,EDID);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }
}
