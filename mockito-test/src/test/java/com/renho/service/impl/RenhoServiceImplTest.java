package com.renho.service.impl;

import com.renho.dao.impl.RenhoDAOImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RenhoServiceImplTest {

    @Mock
    private RenhoDAOImpl renhoDAOMock;

    @Mock
    private RenhoServiceImpl renhoServiceMock;
    @InjectMocks
    private RenhoServiceImpl renhoServiceInjectMocks = new RenhoServiceImpl();
    @Spy
    private RenhoServiceImpl renhoServiceSpy = new RenhoServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShow() {
        String name = "renho";
        Mockito.when(this.renhoDAOMock.show(name)).thenReturn("renho: " + name);
        this.renhoServiceMock.show(name);
        System.out.println("---------------------->");
        this.renhoServiceInjectMocks.show(name);
        System.out.println("---------------------->");
        this.renhoServiceSpy.show(name);
        System.out.println("---------------------->");
    }
}