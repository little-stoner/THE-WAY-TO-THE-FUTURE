//
// Created by viber on 2023/2/1.
//

#include <stdlib.h>

typedef struct String_Struct* String;

struct String_Struct
{
    struct {
        char * value;
    } * internal;
    char* (*get)(const void* self);
    void (*set)(const void* self, char* value);
    int (*length)(const void* self);
};

char* getString(const void* self);
void setString(const void* self, char* value);
int lengthString(const void* self);

String newString();

String newString()
{
    String self = (String)malloc(sizeof(struct String_Struct));

    self->get = &getString;
    self->set = &setString;
    self->length = &lengthString;

    self->set(self, "");

    return self;
}

char* getString(const void* self_obj)
{
    return ((String)self_obj)->internal->value;
}

typedef struct ImmutableString_Struct* ImmutableString;

struct ImmutableString_Struct
{
    String base;

    char* (*get)(const void* self);
    int (*length)(const void* self);
};

ImmutableString newImmutableString(const char* value);

ImmutableString newImmutableString(const char* value)
{
    ImmutableString self = (ImmutableString)malloc(sizeof(struct ImmutableString_Struct));

    self->base = newString();

    self->get = self->base->get;
    self->length = self->base->length;

    self->base->set(self->base, (char*)value);

    return self;
}