package io.github.wjur.avsc2avdl.adapter.json.kotlinx

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KotlinxSchemaConverterTest {

    private val converter = KotlinxSchemaConverter()

    @Test
    fun `should read schema header`() {
        // given
        val schemaString = """
            {
                "type": "record",
                "name": "ObjectName",
                "namespace": "this.is.the.namespace",
                "doc": "Super object for test purposes",
                "fields": []
            }
        """.trimIndent()

        // when
        val schema = converter.convert(schemaString)

        // then
        assertThat(schema.name).isEqualTo("ObjectName")
        assertThat(schema.namespace).isEqualTo("this.is.the.namespace")
        assertThat(schema.documentation).isEqualTo("Super object for test purposes")
    }
}
