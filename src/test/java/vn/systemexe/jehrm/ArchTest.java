package vn.systemexe.jehrm;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("vn.systemexe.jehrm");

        noClasses()
            .that()
            .resideInAnyPackage("vn.systemexe.jehrm.service..")
            .or()
            .resideInAnyPackage("vn.systemexe.jehrm.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..vn.systemexe.jehrm.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
