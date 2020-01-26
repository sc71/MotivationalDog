package com.example.motivationaldog;

import com.google.gson.annotations.SerializedName;

public class Links {
    private Replies[] replies, author, curies, self,
            collection, about;
    @SerializedName("wp:term")
    private Replies[] wpTerm;
    @SerializedName("wp:attachment")
    private Replies[] wpAttachment;
    @SerializedName("predecessor-version")
    private Replies[] predecessorVersion;
    @SerializedName("version-history")
    private VersionHistory[] versionHistory;

    public Links(Replies[] self, Replies[] collection, Replies[] about,
                 Replies[] author, Replies[] replies,
                 VersionHistory[] versionHistory, Replies[] predecessorVersion,
                 Replies[] wpAttachment, Replies[] wpTerm,
                 Replies[] curies) {
        this.self = self;
        this.collection = collection;
        this.about = about;
        this.author = author;
        this.replies = replies;
        this.versionHistory = versionHistory;
        this.predecessorVersion = predecessorVersion;
        this.wpAttachment = wpAttachment;
        this.wpTerm = wpTerm;
        this. curies = curies;
    }
}