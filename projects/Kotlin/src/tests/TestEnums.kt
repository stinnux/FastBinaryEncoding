package tests

import kotlin.test.*
import org.testng.annotations.*

class TestEnums
{
    @Test
    fun serializationEnums()
    {
        val enums1 = enums.Enums()

        // Serialize enums to the FBE stream
        val writer = enums.fbe.EnumsModel()
        assertEquals(writer.model.fbeOffset, 4)
        val serialized = writer.serialize(enums1)
        assertEquals(serialized, writer.buffer.size)
        assertTrue(writer.verify())
        writer.next(serialized)
        assertEquals(writer.model.fbeOffset, 4 + writer.buffer.size)

        // Check the serialized FBE size
        assertEquals(writer.buffer.size, 232)

        // Deserialize enums from the FBE stream
        val enums2 = enums.Enums()
        val reader = enums.fbe.EnumsModel()
        assertEquals(reader.model.fbeOffset, 4)
        reader.attach(writer.buffer)
        assertTrue(reader.verify())
        val deserialized = reader.deserialize(enums2)
        assertEquals(deserialized, reader.buffer.size)
        reader.next(deserialized)
        assertEquals(reader.model.fbeOffset, 4 + reader.buffer.size)

        assertEquals(enums2.byte0, enums.EnumByte.ENUM_VALUE_0)
        assertEquals(enums2.byte1, enums.EnumByte.ENUM_VALUE_1)
        assertEquals(enums2.byte2, enums.EnumByte.ENUM_VALUE_2)
        assertEquals(enums2.byte3, enums.EnumByte.ENUM_VALUE_3)
        assertEquals(enums2.byte4, enums.EnumByte.ENUM_VALUE_4)
        assertEquals(enums2.byte5, enums1.byte3)

        assertEquals(enums2.char0, enums.EnumChar.ENUM_VALUE_0)
        assertEquals(enums2.char1, enums.EnumChar.ENUM_VALUE_1)
        assertEquals(enums2.char2, enums.EnumChar.ENUM_VALUE_2)
        assertEquals(enums2.char3, enums.EnumChar.ENUM_VALUE_3)
        assertEquals(enums2.char4, enums.EnumChar.ENUM_VALUE_4)
        assertEquals(enums2.char5, enums1.char3)

        assertEquals(enums2.wchar0, enums.EnumWChar.ENUM_VALUE_0)
        assertEquals(enums2.wchar1, enums.EnumWChar.ENUM_VALUE_1)
        assertEquals(enums2.wchar2, enums.EnumWChar.ENUM_VALUE_2)
        assertEquals(enums2.wchar3, enums.EnumWChar.ENUM_VALUE_3)
        assertEquals(enums2.wchar4, enums.EnumWChar.ENUM_VALUE_4)
        assertEquals(enums2.wchar5, enums1.wchar3)

        assertEquals(enums2.int8b0, enums.EnumInt8.ENUM_VALUE_0)
        assertEquals(enums2.int8b1, enums.EnumInt8.ENUM_VALUE_1)
        assertEquals(enums2.int8b2, enums.EnumInt8.ENUM_VALUE_2)
        assertEquals(enums2.int8b3, enums.EnumInt8.ENUM_VALUE_3)
        assertEquals(enums2.int8b4, enums.EnumInt8.ENUM_VALUE_4)
        assertEquals(enums2.int8b5, enums1.int8b3)

        assertEquals(enums2.uint8b0, enums.EnumUInt8.ENUM_VALUE_0)
        assertEquals(enums2.uint8b1, enums.EnumUInt8.ENUM_VALUE_1)
        assertEquals(enums2.uint8b2, enums.EnumUInt8.ENUM_VALUE_2)
        assertEquals(enums2.uint8b3, enums.EnumUInt8.ENUM_VALUE_3)
        assertEquals(enums2.uint8b4, enums.EnumUInt8.ENUM_VALUE_4)
        assertEquals(enums2.uint8b5, enums1.uint8b3)

        assertEquals(enums2.int16b0, enums.EnumInt16.ENUM_VALUE_0)
        assertEquals(enums2.int16b1, enums.EnumInt16.ENUM_VALUE_1)
        assertEquals(enums2.int16b2, enums.EnumInt16.ENUM_VALUE_2)
        assertEquals(enums2.int16b3, enums.EnumInt16.ENUM_VALUE_3)
        assertEquals(enums2.int16b4, enums.EnumInt16.ENUM_VALUE_4)
        assertEquals(enums2.int16b5, enums1.int16b3)

        assertEquals(enums2.uint16b0, enums.EnumUInt16.ENUM_VALUE_0)
        assertEquals(enums2.uint16b1, enums.EnumUInt16.ENUM_VALUE_1)
        assertEquals(enums2.uint16b2, enums.EnumUInt16.ENUM_VALUE_2)
        assertEquals(enums2.uint16b3, enums.EnumUInt16.ENUM_VALUE_3)
        assertEquals(enums2.uint16b4, enums.EnumUInt16.ENUM_VALUE_4)
        assertEquals(enums2.uint16b5, enums1.uint16b3)

        assertEquals(enums2.int32b0, enums.EnumInt32.ENUM_VALUE_0)
        assertEquals(enums2.int32b1, enums.EnumInt32.ENUM_VALUE_1)
        assertEquals(enums2.int32b2, enums.EnumInt32.ENUM_VALUE_2)
        assertEquals(enums2.int32b3, enums.EnumInt32.ENUM_VALUE_3)
        assertEquals(enums2.int32b4, enums.EnumInt32.ENUM_VALUE_4)
        assertEquals(enums2.int32b5, enums1.int32b3)

        assertEquals(enums2.uint32b0, enums.EnumUInt32.ENUM_VALUE_0)
        assertEquals(enums2.uint32b1, enums.EnumUInt32.ENUM_VALUE_1)
        assertEquals(enums2.uint32b2, enums.EnumUInt32.ENUM_VALUE_2)
        assertEquals(enums2.uint32b3, enums.EnumUInt32.ENUM_VALUE_3)
        assertEquals(enums2.uint32b4, enums.EnumUInt32.ENUM_VALUE_4)
        assertEquals(enums2.uint32b5, enums1.uint32b3)

        assertEquals(enums2.int64b0, enums.EnumInt64.ENUM_VALUE_0)
        assertEquals(enums2.int64b1, enums.EnumInt64.ENUM_VALUE_1)
        assertEquals(enums2.int64b2, enums.EnumInt64.ENUM_VALUE_2)
        assertEquals(enums2.int64b3, enums.EnumInt64.ENUM_VALUE_3)
        assertEquals(enums2.int64b4, enums.EnumInt64.ENUM_VALUE_4)
        assertEquals(enums2.int64b5, enums1.int64b3)

        assertEquals(enums2.uint64b0, enums.EnumUInt64.ENUM_VALUE_0)
        assertEquals(enums2.uint64b1, enums.EnumUInt64.ENUM_VALUE_1)
        assertEquals(enums2.uint64b2, enums.EnumUInt64.ENUM_VALUE_2)
        assertEquals(enums2.uint64b3, enums.EnumUInt64.ENUM_VALUE_3)
        assertEquals(enums2.uint64b4, enums.EnumUInt64.ENUM_VALUE_4)
        assertEquals(enums2.uint64b5, enums1.uint64b3)
    }

    @Test
    fun serializationFinalEnums()
    {
        val enums1 = enums.Enums()

        // Serialize enums to the FBE stream
        val writer = enums.fbe.EnumsFinalModel()
        val serialized = writer.serialize(enums1)
        assertEquals(serialized, writer.buffer.size)
        assertTrue(writer.verify())
        writer.next(serialized)

        // Check the serialized FBE size
        assertEquals(writer.buffer.size, 224)

        // Deserialize enums from the FBE stream
        val enums2 = enums.Enums()
        val reader = enums.fbe.EnumsFinalModel()
        reader.attach(writer.buffer)
        assertTrue(reader.verify())
        val deserialized = reader.deserialize(enums2)
        assertEquals(deserialized, reader.buffer.size)
        reader.next(deserialized)

        assertEquals(enums2.byte0, enums.EnumByte.ENUM_VALUE_0)
        assertEquals(enums2.byte1, enums.EnumByte.ENUM_VALUE_1)
        assertEquals(enums2.byte2, enums.EnumByte.ENUM_VALUE_2)
        assertEquals(enums2.byte3, enums.EnumByte.ENUM_VALUE_3)
        assertEquals(enums2.byte4, enums.EnumByte.ENUM_VALUE_4)
        assertEquals(enums2.byte5, enums1.byte3)

        assertEquals(enums2.char0, enums.EnumChar.ENUM_VALUE_0)
        assertEquals(enums2.char1, enums.EnumChar.ENUM_VALUE_1)
        assertEquals(enums2.char2, enums.EnumChar.ENUM_VALUE_2)
        assertEquals(enums2.char3, enums.EnumChar.ENUM_VALUE_3)
        assertEquals(enums2.char4, enums.EnumChar.ENUM_VALUE_4)
        assertEquals(enums2.char5, enums1.char3)

        assertEquals(enums2.wchar0, enums.EnumWChar.ENUM_VALUE_0)
        assertEquals(enums2.wchar1, enums.EnumWChar.ENUM_VALUE_1)
        assertEquals(enums2.wchar2, enums.EnumWChar.ENUM_VALUE_2)
        assertEquals(enums2.wchar3, enums.EnumWChar.ENUM_VALUE_3)
        assertEquals(enums2.wchar4, enums.EnumWChar.ENUM_VALUE_4)
        assertEquals(enums2.wchar5, enums1.wchar3)

        assertEquals(enums2.int8b0, enums.EnumInt8.ENUM_VALUE_0)
        assertEquals(enums2.int8b1, enums.EnumInt8.ENUM_VALUE_1)
        assertEquals(enums2.int8b2, enums.EnumInt8.ENUM_VALUE_2)
        assertEquals(enums2.int8b3, enums.EnumInt8.ENUM_VALUE_3)
        assertEquals(enums2.int8b4, enums.EnumInt8.ENUM_VALUE_4)
        assertEquals(enums2.int8b5, enums1.int8b3)

        assertEquals(enums2.uint8b0, enums.EnumUInt8.ENUM_VALUE_0)
        assertEquals(enums2.uint8b1, enums.EnumUInt8.ENUM_VALUE_1)
        assertEquals(enums2.uint8b2, enums.EnumUInt8.ENUM_VALUE_2)
        assertEquals(enums2.uint8b3, enums.EnumUInt8.ENUM_VALUE_3)
        assertEquals(enums2.uint8b4, enums.EnumUInt8.ENUM_VALUE_4)
        assertEquals(enums2.uint8b5, enums1.uint8b3)

        assertEquals(enums2.int16b0, enums.EnumInt16.ENUM_VALUE_0)
        assertEquals(enums2.int16b1, enums.EnumInt16.ENUM_VALUE_1)
        assertEquals(enums2.int16b2, enums.EnumInt16.ENUM_VALUE_2)
        assertEquals(enums2.int16b3, enums.EnumInt16.ENUM_VALUE_3)
        assertEquals(enums2.int16b4, enums.EnumInt16.ENUM_VALUE_4)
        assertEquals(enums2.int16b5, enums1.int16b3)

        assertEquals(enums2.uint16b0, enums.EnumUInt16.ENUM_VALUE_0)
        assertEquals(enums2.uint16b1, enums.EnumUInt16.ENUM_VALUE_1)
        assertEquals(enums2.uint16b2, enums.EnumUInt16.ENUM_VALUE_2)
        assertEquals(enums2.uint16b3, enums.EnumUInt16.ENUM_VALUE_3)
        assertEquals(enums2.uint16b4, enums.EnumUInt16.ENUM_VALUE_4)
        assertEquals(enums2.uint16b5, enums1.uint16b3)

        assertEquals(enums2.int32b0, enums.EnumInt32.ENUM_VALUE_0)
        assertEquals(enums2.int32b1, enums.EnumInt32.ENUM_VALUE_1)
        assertEquals(enums2.int32b2, enums.EnumInt32.ENUM_VALUE_2)
        assertEquals(enums2.int32b3, enums.EnumInt32.ENUM_VALUE_3)
        assertEquals(enums2.int32b4, enums.EnumInt32.ENUM_VALUE_4)
        assertEquals(enums2.int32b5, enums1.int32b3)

        assertEquals(enums2.uint32b0, enums.EnumUInt32.ENUM_VALUE_0)
        assertEquals(enums2.uint32b1, enums.EnumUInt32.ENUM_VALUE_1)
        assertEquals(enums2.uint32b2, enums.EnumUInt32.ENUM_VALUE_2)
        assertEquals(enums2.uint32b3, enums.EnumUInt32.ENUM_VALUE_3)
        assertEquals(enums2.uint32b4, enums.EnumUInt32.ENUM_VALUE_4)
        assertEquals(enums2.uint32b5, enums1.uint32b3)

        assertEquals(enums2.int64b0, enums.EnumInt64.ENUM_VALUE_0)
        assertEquals(enums2.int64b1, enums.EnumInt64.ENUM_VALUE_1)
        assertEquals(enums2.int64b2, enums.EnumInt64.ENUM_VALUE_2)
        assertEquals(enums2.int64b3, enums.EnumInt64.ENUM_VALUE_3)
        assertEquals(enums2.int64b4, enums.EnumInt64.ENUM_VALUE_4)
        assertEquals(enums2.int64b5, enums1.int64b3)

        assertEquals(enums2.uint64b0, enums.EnumUInt64.ENUM_VALUE_0)
        assertEquals(enums2.uint64b1, enums.EnumUInt64.ENUM_VALUE_1)
        assertEquals(enums2.uint64b2, enums.EnumUInt64.ENUM_VALUE_2)
        assertEquals(enums2.uint64b3, enums.EnumUInt64.ENUM_VALUE_3)
        assertEquals(enums2.uint64b4, enums.EnumUInt64.ENUM_VALUE_4)
        assertEquals(enums2.uint64b5, enums1.uint64b3)
    }

    @Test
    fun serializationJsonEnums()
    {
        // Define a source JSON string
        var json = """{"byte0":0,"byte1":0,"byte2":1,"byte3":254,"byte4":255,"byte5":254,"char0":0,"char1":49,"char2":50,"char3":51,"char4":52,"char5":51,"wchar0":0,"wchar1":1092,"wchar2":1093,"wchar3":1365,"wchar4":1366,"wchar5":1365,"int8b0":0,"int8b1":-128,"int8b2":-127,"int8b3":126,"int8b4":127,"int8b5":126,"uint8b0":0,"uint8b1":0,"uint8b2":1,"uint8b3":254,"uint8b4":255,"uint8b5":254,"int16b0":0,"int16b1":-32768,"int16b2":-32767,"int16b3":32766,"int16b4":32767,"int16b5":32766,"uint16b0":0,"uint16b1":0,"uint16b2":1,"uint16b3":65534,"uint16b4":65535,"uint16b5":65534,"int32b0":0,"int32b1":-2147483648,"int32b2":-2147483647,"int32b3":2147483646,"int32b4":2147483647,"int32b5":2147483646,"uint32b0":0,"uint32b1":0,"uint32b2":1,"uint32b3":4294967294,"uint32b4":4294967295,"uint32b5":4294967294,"int64b0":0,"int64b1":-9223372036854775807,"int64b2":-9223372036854775806,"int64b3":9223372036854775806,"int64b4":9223372036854775807,"int64b5":9223372036854775806,"uint64b0":0,"uint64b1":0,"uint64b2":1,"uint64b3":18446744073709551614,"uint64b4":18446744073709551615,"uint64b5":18446744073709551614}"""

        // Create enums from the source JSON string
        val enums1 = enums.Enums.fromJson(json)

        // Serialize enums to the JSON string
        json = enums1.toJson()

        // Check the serialized JSON size
        assertTrue(json.isNotEmpty())

        // Deserialize enums from the JSON string
        val enums2 = enums.Enums.fromJson(json)

        assertEquals(enums2.byte0, enums.EnumByte.ENUM_VALUE_0)
        assertEquals(enums2.byte1, enums.EnumByte.ENUM_VALUE_1)
        assertEquals(enums2.byte2, enums.EnumByte.ENUM_VALUE_2)
        assertEquals(enums2.byte3, enums.EnumByte.ENUM_VALUE_3)
        assertEquals(enums2.byte4, enums.EnumByte.ENUM_VALUE_4)
        assertEquals(enums2.byte5, enums1.byte3)

        assertEquals(enums2.char0, enums.EnumChar.ENUM_VALUE_0)
        assertEquals(enums2.char1, enums.EnumChar.ENUM_VALUE_1)
        assertEquals(enums2.char2, enums.EnumChar.ENUM_VALUE_2)
        assertEquals(enums2.char3, enums.EnumChar.ENUM_VALUE_3)
        assertEquals(enums2.char4, enums.EnumChar.ENUM_VALUE_4)
        assertEquals(enums2.char5, enums1.char3)

        assertEquals(enums2.wchar0, enums.EnumWChar.ENUM_VALUE_0)
        assertEquals(enums2.wchar1, enums.EnumWChar.ENUM_VALUE_1)
        assertEquals(enums2.wchar2, enums.EnumWChar.ENUM_VALUE_2)
        assertEquals(enums2.wchar3, enums.EnumWChar.ENUM_VALUE_3)
        assertEquals(enums2.wchar4, enums.EnumWChar.ENUM_VALUE_4)
        assertEquals(enums2.wchar5, enums1.wchar3)

        assertEquals(enums2.int8b0, enums.EnumInt8.ENUM_VALUE_0)
        assertEquals(enums2.int8b1, enums.EnumInt8.ENUM_VALUE_1)
        assertEquals(enums2.int8b2, enums.EnumInt8.ENUM_VALUE_2)
        assertEquals(enums2.int8b3, enums.EnumInt8.ENUM_VALUE_3)
        assertEquals(enums2.int8b4, enums.EnumInt8.ENUM_VALUE_4)
        assertEquals(enums2.int8b5, enums1.int8b3)

        assertEquals(enums2.uint8b0, enums.EnumUInt8.ENUM_VALUE_0)
        assertEquals(enums2.uint8b1, enums.EnumUInt8.ENUM_VALUE_1)
        assertEquals(enums2.uint8b2, enums.EnumUInt8.ENUM_VALUE_2)
        assertEquals(enums2.uint8b3, enums.EnumUInt8.ENUM_VALUE_3)
        assertEquals(enums2.uint8b4, enums.EnumUInt8.ENUM_VALUE_4)
        assertEquals(enums2.uint8b5, enums1.uint8b3)

        assertEquals(enums2.int16b0, enums.EnumInt16.ENUM_VALUE_0)
        assertEquals(enums2.int16b1, enums.EnumInt16.ENUM_VALUE_1)
        assertEquals(enums2.int16b2, enums.EnumInt16.ENUM_VALUE_2)
        assertEquals(enums2.int16b3, enums.EnumInt16.ENUM_VALUE_3)
        assertEquals(enums2.int16b4, enums.EnumInt16.ENUM_VALUE_4)
        assertEquals(enums2.int16b5, enums1.int16b3)

        assertEquals(enums2.uint16b0, enums.EnumUInt16.ENUM_VALUE_0)
        assertEquals(enums2.uint16b1, enums.EnumUInt16.ENUM_VALUE_1)
        assertEquals(enums2.uint16b2, enums.EnumUInt16.ENUM_VALUE_2)
        assertEquals(enums2.uint16b3, enums.EnumUInt16.ENUM_VALUE_3)
        assertEquals(enums2.uint16b4, enums.EnumUInt16.ENUM_VALUE_4)
        assertEquals(enums2.uint16b5, enums1.uint16b3)

        assertEquals(enums2.int32b0, enums.EnumInt32.ENUM_VALUE_0)
        assertEquals(enums2.int32b1, enums.EnumInt32.ENUM_VALUE_1)
        assertEquals(enums2.int32b2, enums.EnumInt32.ENUM_VALUE_2)
        assertEquals(enums2.int32b3, enums.EnumInt32.ENUM_VALUE_3)
        assertEquals(enums2.int32b4, enums.EnumInt32.ENUM_VALUE_4)
        assertEquals(enums2.int32b5, enums1.int32b3)

        assertEquals(enums2.uint32b0, enums.EnumUInt32.ENUM_VALUE_0)
        assertEquals(enums2.uint32b1, enums.EnumUInt32.ENUM_VALUE_1)
        assertEquals(enums2.uint32b2, enums.EnumUInt32.ENUM_VALUE_2)
        assertEquals(enums2.uint32b3, enums.EnumUInt32.ENUM_VALUE_3)
        assertEquals(enums2.uint32b4, enums.EnumUInt32.ENUM_VALUE_4)
        assertEquals(enums2.uint32b5, enums1.uint32b3)

        assertEquals(enums2.int64b0, enums.EnumInt64.ENUM_VALUE_0)
        assertEquals(enums2.int64b1, enums.EnumInt64.ENUM_VALUE_1)
        assertEquals(enums2.int64b2, enums.EnumInt64.ENUM_VALUE_2)
        assertEquals(enums2.int64b3, enums.EnumInt64.ENUM_VALUE_3)
        assertEquals(enums2.int64b4, enums.EnumInt64.ENUM_VALUE_4)
        assertEquals(enums2.int64b5, enums1.int64b3)

        assertEquals(enums2.uint64b0, enums.EnumUInt64.ENUM_VALUE_0)
        assertEquals(enums2.uint64b1, enums.EnumUInt64.ENUM_VALUE_1)
        assertEquals(enums2.uint64b2, enums.EnumUInt64.ENUM_VALUE_2)
        assertEquals(enums2.uint64b3, enums.EnumUInt64.ENUM_VALUE_3)
        assertEquals(enums2.uint64b4, enums.EnumUInt64.ENUM_VALUE_4)
        assertEquals(enums2.uint64b5, enums1.uint64b3)
    }
}
