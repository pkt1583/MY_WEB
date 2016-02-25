import com.test.domain.Component
import org.junit.Test

/**
 * Created by pankaj on 28-05-2016.
 */
class ComponentModelTest extends GroovyTestCase {
    @Test
    void testComponentModel(){
        def componentModel=new Component(componentId: 100,componentName: "Some Component")
        assertTrue(componentModel.componentId==100)
    }
}
