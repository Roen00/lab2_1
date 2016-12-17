package edu.iis.mto.bsearch;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchResultTest {

    @Test
    public void isFoundShouldReturnTrueForPosition0() {
        final SearchResult sut = new SearchResult();
        sut.setPosition(0);
        assertThat(sut.isFound(), is(true));
    }

    @Test
    public void isFoundShouldReturnTrueForPosition1() {
        final SearchResult sut = new SearchResult();
        sut.setPosition(1);
        assertThat(sut.isFound(), is(true));
    }

    @Test
    public void isFoundShouldReturnFalseForPositionMinus1() {
        final SearchResult sut = new SearchResult();
        sut.setPosition(-1);
        assertThat(sut.isFound(), is(false));
    }

    @Test
    public void equalsReturnTrueIfTwoDifferentInstancesHaveTheSamePosition() {
        final SearchResult sut1 = new SearchResult();
        sut1.setPosition(1);
        final SearchResult sut2 = new SearchResult();
        sut2.setPosition(1);

        assertThat(sut1.equals(sut2), is(true));
    }

    @Test
    public void equalsReturnFalseIfTwoDifferentInstancesHaveDifferentPosition() {
        final SearchResult sut1 = new SearchResult();
        sut1.setPosition(1);
        final SearchResult sut2 = new SearchResult();
        sut2.setPosition(2);

        assertThat(sut1.equals(sut2), is(false));
    }
}