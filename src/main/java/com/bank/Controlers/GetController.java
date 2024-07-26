package com.bank.Controlers;

import com.bank.DB.ED807Entity;
import com.bank.DTO.ru.cbr.ed.v2.ED807;
import com.bank.Service.ED807Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/get")
@Tag(name = "GetController", description = "Контроллер для  получении информации о сущностях хранящихся в бд")
@SecurityRequirement(name = "basicAuth")
public class GetController {

    @Autowired
    private ED807Service ed807Service;

    @Operation(
            summary = "Получение всех ED807 по имени",
            description = "Позволяет передать пользователю краткую информацию без bic обо всех ED807 c именем"
    )
    @GetMapping("/{name}")
    public ResponseEntity<List<ED807>> getALLByName(@Parameter(description = "Название ed807")
                                                        @PathVariable String name) {
        List<ED807> ed807List = ed807Service.getAllED807ByName(name);
        if (ed807List != null && !ed807List.isEmpty()) {
            return ResponseEntity.ok(ed807List);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(
            summary = "Получение всех ED807",
            description = "Позволяет передать пользователю краткую информацию без bic обо всех ED807"
    )
    @GetMapping("/all")
    public ResponseEntity<List<ED807>> getAllED807() {
        List<ED807> ed807List = ed807Service.getAllED807();
        return ResponseEntity.ok(ed807List);
    }
    @Operation(
            summary = "Получение всех ED807 по дате",
            description = "Позволяет передать пользователю краткую информацию " +
                    "без bic обо всех ED807 c введенной даты до введеной даты"
    )
    @GetMapping("/by-date-range")
    public ResponseEntity<List<ED807>> getAllBetweenDate(
            @Parameter(description = "Дата с которой ищет")@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @Parameter(description = "Дата до которой ищет")@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate){


        List<ED807> ed807List = ed807Service.getAllBetwenDate(startDate,endDate);
        if (ed807List != null && !ed807List.isEmpty()) {
            return ResponseEntity.ok(ed807List);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(
            summary = "Получение всех ED807 по id",
            description = "Позволяет передать пользователю полную информацию по id"
    )
    @GetMapping("/by_id")
    public ResponseEntity<ED807> getById(@Parameter(description = "Идентификатор ED807")@RequestParam BigInteger id){
        ED807 ed807 = ed807Service.getById(id);
        if(ed807 != null){
            return ResponseEntity.ok(ed807);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}

