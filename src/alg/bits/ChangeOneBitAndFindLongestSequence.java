package alg.bits;

import java.util.ArrayList;
import java.util.List;

/**
 * Имеется целое число в котором можно изменить ровно один бит из 0 в 1. Напишитн код для определения длины самой длинной
 * последовательности единиц, которая может быть при этом получена.
 */

public class ChangeOneBitAndFindLongestSequence {

    public static void main(String[] args) {
        int test = 5;
        System.out.println(getAlternatingSequences(test));
    }

// Non optimal decision
// ----------------------------------------------------------------------------------------------- //

    static int longestSequence(int n) {
        if (n == -1) {
            return Integer.BYTES * 8;
        }
        ArrayList<Integer> sequences = getAlternatingSequences(n);
        return findLongestSequence(sequences);
    }

    static ArrayList<Integer> getAlternatingSequences(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;
        for (int i = 0; i < Integer.BYTES * 8; ++i) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1;
                counter = 0;
            }
            counter++;
            n >>>= 1;
        }
        sequences.add(counter);
        return sequences;
    }

    static int findLongestSequence(List<Integer> seq) {
        int maxSeq = 1;

        for (int i = 0; i < seq.size(); i += 2) {
            int zerosSeq = seq.get(0);
            int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;
            if (zerosSeq == 1) {
                thisSeq = onesSeqLeft + 1 + onesSeqRight;
            }
            if (zerosSeq > 1) {
                thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
            } else if (zerosSeq == 0) {
                thisSeq = Math.max(onesSeqLeft, onesSeqRight);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }
        return maxSeq;
    }

// Optimal (in terms of memory O(1) )decision
// ----------------------------------------------------------------------------------------------- //

    static int flip(int a) {
        if (~a == 0) {
            return Integer.BYTES * 8;
        }

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;

        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else if ((a & 1) == 0) {
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }
}
