package com.online.Smart_Online_Shopping_Platform.service;

import com.online.Smart_Online_Shopping_Platform.dto.request.CardRequestDto;
import com.online.Smart_Online_Shopping_Platform.dto.response.CardResponseDto;
import com.online.Smart_Online_Shopping_Platform.exception.CustomerNotFoundException;
import com.online.Smart_Online_Shopping_Platform.model.Card;
import com.online.Smart_Online_Shopping_Platform.model.Customer;
import com.online.Smart_Online_Shopping_Platform.repository.CustomerRepository;
import com.online.Smart_Online_Shopping_Platform.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CustomerRepository customerRepository;

    public CardResponseDto addCard(CardRequestDto cardRequestDto){

        Customer customer = customerRepository.findByMobNo(cardRequestDto.getCustomerMobile());
        if(customer==null){
            throw new CustomerNotFoundException("Customer doesn't exist");
        }

        // create card entity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        Customer savedCustomer = customerRepository.save(customer);
        List<Card> cards = savedCustomer.getCards();
        Card latestCard = cards.get(cards.size()-1);

        // prepare card response dto
        CardResponseDto cardResponseDto = CardTransformer.CardToCardResponseDto(latestCard);
        cardResponseDto.setCardNo(generateMaskedCard(latestCard.getCardNo()));

        return cardResponseDto;
    }

    public String generateMaskedCard(String cardNo){
        int cardLength = cardNo.length();
        String maskedCard = "";
        for(int i = 0;i<cardLength-4;i++){
            maskedCard += 'X';
        }

        maskedCard += cardNo.substring(cardLength-4);
        return maskedCard;
    }
}