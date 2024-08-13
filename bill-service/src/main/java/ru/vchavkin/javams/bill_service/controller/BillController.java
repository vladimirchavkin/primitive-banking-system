package ru.vchavkin.javams.bill_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vchavkin.javams.bill_service.controller.dto.BillRequestDTO;
import ru.vchavkin.javams.bill_service.controller.dto.BillResponseDTO;
import ru.vchavkin.javams.bill_service.exceptions.BillException;
import ru.vchavkin.javams.bill_service.service.BillService;

/**
 * @author vladimirchavkinwork@gmail.com
 */

@RestController
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    /**
     * Get bill by id.
     *
     * @param billId Bill id.
     * @return Bill by billId. If an bill does not exist, throws BillException
     */
    @Operation(
            summary = "Get bill by id.",
            description = "Endpoint to get bill by id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully received",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @GetMapping("/{billId}")
    public BillResponseDTO getBillById(@PathVariable Long billId) {
        return new BillResponseDTO(billService.getBillById(billId));
    }

    /**
     * Create bill.
     *
     * @param billRequestDTO for creating bill.
     * @return Created bill response.
     */
    @Operation(
            summary = "Create bill",
            description = "Endpoint to create bill"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully created",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @PostMapping("/")
    public BillResponseDTO createBill(@RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.createBill(billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled()));
    }

    /**
     * Delete bill by billId.
     *
     * @param billId for deleting bill.
     * @return Deleted bill by billId.
     */
    @Operation(
            summary = "Delete bill",
            description = "Endpoint to delete bill"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully deleted",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @DeleteMapping("/{billId}")
    public BillResponseDTO deleteBill(@PathVariable Long billId) {
        return new BillResponseDTO(billService.deleteById(billId));
    }

    /**
     * Update bill.
     *
     * @param billId Bill id
     * @param billRequestDTO DTO for update bill.
     * @return Updated bill response.
     */
    @Operation(
            summary = "Update bill",
            description = "Endpoint to update bill"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(
                            description = "The object was successfully updated",
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(
                            description = "Error sending the request.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(
                            description = "The entity was not found.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(
                            description = "Internal server error.",
                            implementation = BillException.class,
                            contentMediaType = "application/json"
                    ))
            })
    })
    @PutMapping("/{billId}")
    public BillResponseDTO updateBill(@PathVariable Long billId,
                                      @RequestBody BillRequestDTO billRequestDTO) {
        return new BillResponseDTO(billService.updateBill(billId, billRequestDTO.getAccountId(), billRequestDTO.getAmount(),
                billRequestDTO.getIsDefault(), billRequestDTO.getOverdraftEnabled()));
    }
}
