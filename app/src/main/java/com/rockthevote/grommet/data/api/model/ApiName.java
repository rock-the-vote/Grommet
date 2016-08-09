package com.rockthevote.grommet.data.api.model;

import com.google.auto.value.AutoValue;
import com.rockthevote.grommet.data.db.model.Name;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class ApiName {
    @Json(name = "first_name")
    abstract String firstName();

    @Json(name = "last_name")
    abstract String lastName();

    @Json(name = "middle_name")
    abstract String middleName();

    @Json(name = "title_prefix")
    abstract String titlePrefix();

    @Json(name = "title_suffix")
    abstract String titleSuffix();

    public static JsonAdapter<ApiName> jsonAdapter(Moshi moshi) {
        return new AutoValue_ApiName.MoshiJsonAdapter(moshi);
    }

    static Builder builder() {
        return new AutoValue_ApiName.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder firstName(String value);

        abstract Builder lastName(String value);

        abstract Builder middleName(String value);

        abstract Builder titlePrefix(String value);

        abstract Builder titleSuffix(String value);

        abstract ApiName build();
    }

    public static ApiName fromDb(Name name) {
        return builder()
                .firstName(name.firstName())
                .lastName(name.lastName())
                .middleName(name.middleName())
                .titlePrefix(name.titlePrefix().toString())
                .titleSuffix(name.titleSuffix().toString())
                .build();
    }
}