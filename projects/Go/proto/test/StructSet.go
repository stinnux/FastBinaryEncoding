// Automatically generated by the Fast Binary Encoding compiler, do not modify!
// https://github.com/chronoxor/FastBinaryEncoding
// Source: test.fbe
// Version: 1.1.0.0

package test

import "strconv"
import "strings"
import "encoding/json"
import "../fbe"
import "../proto"

// Workaround for Go unused imports issue
var _ = fbe.Version
var _ = proto.Version

// StructSet key
type StructSetKey struct {
}

// Convert StructSet flags key to string
func (k StructSetKey) String() string {
    var sb strings.Builder
    return sb.String()
}

// StructSet struct
type StructSet struct {
    F1 map[byte]bool `json:"f1"`
    F2 map[EnumSimpleKey]bool `json:"f2"`
    F3 map[FlagsSimpleKey]bool `json:"f3"`
    F4 map[StructSimpleKey]bool `json:"f4"`
}

// Create a new StructSet struct
func NewStructSet() *StructSet {
    return &StructSet{
        F1: make(map[byte]bool),
        F2: make(map[EnumSimpleKey]bool),
        F3: make(map[FlagsSimpleKey]bool),
        F4: make(map[StructSimpleKey]bool),
    }
}

// Create a new StructSet struct from JSON
func NewStructSetFromJSON(buffer []byte) (*StructSet, error) {
    var result StructSet
    err := json.Unmarshal(buffer, &result)
    if err != nil {
        return nil, err
    }
    return &result, nil
}

// Struct shallow copy
func (s StructSet) Copy() *StructSet {
    var result = s
    return &result
}

// Struct deep clone
func (s StructSet) Clone() *StructSet {
    var result = s
    return &result
}

// Get the struct key
func (s StructSet) Key() StructSetKey {
    return StructSetKey{
    }
}

// Convert struct to optional
func (s StructSet) Optional() *StructSet {
    return &s
}

// Convert struct to string
func (s StructSet) String() string {
    var sb strings.Builder
    return sb.String()
}

// Convert struct to JSON
func (s StructSet) JSON() ([]byte, error) {
    return json.Marshal(s)
}
