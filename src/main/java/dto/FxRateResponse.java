/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author mxolisi
 */
@Getter
@AllArgsConstructor
public class FxRateResponse {

    private String fromCurrency;
    private String toCurrency;
    private float exchangeRate;
}
