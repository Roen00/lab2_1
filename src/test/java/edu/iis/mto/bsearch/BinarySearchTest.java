package edu.iis.mto.bsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BinarySearchTest {

    private int[] seq;
    private int searchedElement;
    private int expectedSearchElementPosition;

    public BinarySearchTest(String collectionName, int[] seq, int searchedElement, int expectedSearchElementPosition) {
        this.seq = seq;
        this.searchedElement = searchedElement;
        this.expectedSearchElementPosition = expectedSearchElementPosition;
    }

    @Parameters(name = "for {0} search should find element with value {2} on position {3}")
    public static Collection parameters() {
        final Object[][] objects = {
                {"collection which contains only one element", new int[]{1}, 1, 0}
        };
        return Arrays.asList(objects);
    }

    @Test
    public void isFound() {
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(expectedSearchElementPosition));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsNotPresentedInSequenceAndSequenceLengthEqualsOne() {
        final int searchedElement = 1;
        final int[] seq = {0};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void elementIsFirstInSequenceAndSequenceLengthIsLargerThanOne() {
        final int searchedElement = 1;
        final int[] seq = {searchedElement, 2, 3};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(0));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsLastInSequenceAndSequenceLengthIsLargerThanOne() {
        final int searchedElement = 3;
        final int[] seq = {1, 2, searchedElement};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(2));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsInTheMiddleOfTheSequenceAndSequenceLengthIsLargerThanOne() {
        final int searchedElement = 2;
        final int[] seq = {1, searchedElement, 3};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(searchResult.getPosition(), is(1));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsNotInTheSequenceAndSequenceLengthIsLargerThanOne() {
        final int searchedElement = 4;
        final int[] seq = {1, 2, 3};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenSequenceIsEmpty() {
        final int searchedElement = 4;
        final int[] emptySeq = {};
        BinarySearch.search(searchedElement, emptySeq);
    }
}
