package com.java.cards.service;

import com.java.cards.dto.CardsDto;
import com.java.cards.entity.Cards;

public interface ICardServiece {

    /**
     * Creates a card associated with the specified mobile number.
     *
     * @param mobileNumber the mobile number associated with the card to be created
     */
    void createCard(String mobileNumber);


    /**
     * Fetches the card information associated with the specified mobile number.
     *
     * @param mobileNumber the mobile number associated with the card to be fetched
     */
    CardsDto fetchCard(String mobileNumber);


    /**
     * Updates the card details using the provided card information.
     *
     * @param cardsDto the CardsDto object containing the updated card information,
     *                 such as mobile number, card number, card type, total limit,
     *                 amount used, and available amount
     * @return true if the card details were successfully updated, false otherwise
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     * Deletes the card associated with the specified mobile number.
     *
     * @param mobileNumber the mobile number associated with the card to be deleted
     */
    boolean deleteCard(String mobileNumber);
}
