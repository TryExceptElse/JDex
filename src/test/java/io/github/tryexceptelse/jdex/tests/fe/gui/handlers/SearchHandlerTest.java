package io.github.tryexceptelse.jdex.tests.fe.gui.handlers;

import io.github.tryexceptelse.jdex.JDex;
import io.github.tryexceptelse.jdex.fe.gui.AppWindow;
import io.github.tryexceptelse.jdex.fe.gui.MainCont;
import io.github.tryexceptelse.jdex.fe.gui.handlers.SearchHandler;
import junit.framework.TestCase;
import org.mockito.Mockito;

/**
 * Test methods of search handler class.
 * As this is a gui handler, the exact outcomes of the methods are hard to
 * test accurately, however they can at least be determined to not raise
 * errors.
 */
public class SearchHandlerTest extends TestCase{
    private MainCont mainContMock;
    private AppWindow appMock;
    private JDex jDexMock;
    private SearchHandler searchHandler;

    /** build search handler which will be used by other methods */
    protected void setUp(){
        mainContMock = Mockito.mock(MainCont.class);
        appMock = Mockito.mock(AppWindow.class);
        Mockito.when(mainContMock.getApp()).thenReturn(appMock);
        jDexMock = Mockito.mock(JDex.class);
        Mockito.when(appMock.getJDex()).thenReturn(jDexMock);
        searchHandler = new SearchHandler(mainContMock);
    }

    /** test that searchButtonPress does not raise an error when called */
    public void testSearchButtonPressDoesNotRaiseErrorWhenCalled(){
        searchHandler.searchButtonPress();
    }
}
