package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void elementIsPresentedInSequenceAndSequenceLengthEqualsOne(){
        final int searchedElement = 1;
        final int[] seq = {searchedElement};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(true));
        assertThat(seq[searchResult.getPosition()], is(searchedElement));
    }

    @Test
    public void elementIsNotPresentedInSequenceAndSequenceLengthEqualsOne(){
        final int searchedElement = 1;
        final int[] seq = {0};
        final SearchResult searchResult = BinarySearch.search(searchedElement, seq);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

}