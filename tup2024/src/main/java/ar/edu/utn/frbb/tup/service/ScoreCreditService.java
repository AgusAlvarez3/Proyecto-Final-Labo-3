package ar.edu.utn.frbb.tup.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ScoreCreditService {
    private final Random random = new Random();

    public boolean verifyEstado(long dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("DNI inválido");
        }
        return random.nextDouble() >= 1.0 / 3.0;
    }
}