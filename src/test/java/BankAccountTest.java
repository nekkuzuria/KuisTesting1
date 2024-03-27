import org.example.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountTest {
    private static BankAccount myBank;
    private static BankAccount shillaBank;
    IllegalArgumentException exception;

    @BeforeEach
    void initMethod(){
        myBank = new BankAccount("24776", 5000);
        shillaBank = new BankAccount("13133", 20000);
    }

    @AfterEach
    void tearDown(){
        // Mengosongkan isi bank
        myBank.withdraw(myBank.getBalance());
    }

    @Test
    void testGetAccountNumer(){
        assertEquals("24776", myBank.getAccountNumber());
    }

    @Test
    void testGetBalance(){
        assertEquals(5000, myBank.getBalance());
    }

    @Test
    void testDeposit(){
        myBank.deposit(5000);
        assertEquals(10000, myBank.getBalance());
    }

    @Test
    void testNegativeDeposit(){
        exception = assertThrows(IllegalArgumentException.class,
                () -> myBank.deposit(-1000));
        assertEquals("Deposit amount cannot be negative.", exception.getMessage());
    }

    @Test
    void testWithdraw(){
        myBank.withdraw(2000);
        assertEquals(3000, myBank.getBalance());
    }

    @Test
    void testNegativeWithdraw(){
        exception = assertThrows(IllegalArgumentException.class,
                () -> myBank.withdraw(20000));
        assertEquals("Insufficient funds for withdraw", exception.getMessage());
    }

    @Test
    void testTransferFunds(){
        myBank.transferFunds(shillaBank, 1000);
        assertEquals(4000, myBank.getBalance());
        assertEquals(21000, shillaBank.getBalance());
    }

    @Test
    void negativeTransferFunds(){
        exception = assertThrows(IllegalArgumentException.class,
                () -> myBank.transferFunds(shillaBank, 20000));
        assertEquals("Insufficient funds for transfer.", exception.getMessage());
    }
}
