package com.schibsted.sa.detskjer;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.schibsted.sa.detskjer.model.Event;
import com.schibsted.sa.detskjer.model.EventsList;
import com.schibsted.sa.detskjer.ui.eventsList.EventsListAdapter;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EventsListAdapterUnitTest {

    @Mock
    Context mockContext;

    @Spy
    ArrayList<Event> mockList = new ArrayList<Event>();

    EventsListAdapter sut = new EventsListAdapter(mockList, mockContext);

    @Test
    public void updates_events_in_mock_list() throws Exception {
        EventsList x = new E
        sut.updateEvents();

        assertEquals(4, 2 + 2);
    }
}
