package Exceptions;

public class SlotExhaustedException extends ExhaustedResourceException {
    SlotExhaustedException(String location , String station) {
        super(String.format("the energies of the slot in  {} in {}  is  over " , location , station));
    }
}
