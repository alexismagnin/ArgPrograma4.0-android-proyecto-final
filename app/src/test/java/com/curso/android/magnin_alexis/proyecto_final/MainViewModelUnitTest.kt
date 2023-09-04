package com.curso.android.magnin_alexis.proyecto_final

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.magnin_alexis.proyecto_final.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValues() = runTest {
        val comparadorInicial = viewModel.comparador.value
        val texto1 = comparadorInicial?.texto1
        val texto2 = comparadorInicial?.texto2
        val resultado = comparadorInicial?.resultado
        assertEquals(null, texto1)
        assertEquals(null, texto2)
        assertEquals(null, resultado)
    }

    @Test
    fun mainViewModel_ComparacionVerdadera() = runTest {
        launch {
            viewModel.compararTextos("hola", "hola")
        }
        advanceUntilIdle()
        val resultado = viewModel.comparador.value?.resultado
        assertEquals(true, resultado)
    }

    @Test
    fun mainViewModel_ComparacionFalsa() = runTest {
        launch {
            viewModel.compararTextos("chau", "hola")
        }
        advanceUntilIdle()
        val resultado = viewModel.comparador.value?.resultado
        assertEquals(false, resultado)
    }

    @Test
    fun mainViewModel_ComparacionNula() = runTest {
        launch {
            viewModel.compararTextos(null, "hola")
        }
        advanceUntilIdle()
        val resultado = viewModel.comparador.value?.resultado
        assertEquals(null, resultado)
    }
}
