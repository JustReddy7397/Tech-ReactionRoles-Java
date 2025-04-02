package ga.justreddy.wiki.database.pojo;

import ga.justreddy.wiki.database.pojo.mode.ReactionButton;
import ga.justreddy.wiki.database.pojo.mode.ReactionDropDown;
import ga.justreddy.wiki.database.pojo.mode.ReactionEmoji;
import ga.justreddy.wiki.database.pojo.mode.ReactionSlash;
import org.bson.types.ObjectId;

import java.util.Set;

/**
 * @author JustReddy
 */
public class ReactionRole {

    private ObjectId id;
    private String reactionRoleId;
    private String guildId;
    private String messageId;
    private Set<String> roleIds;
    private Set<ReactionButton> reactionButtons;
    private Set<ReactionEmoji> reactionEmojis;
    private Set<ReactionSlash> reactionSlashes;
    private Set<ReactionDropDown> reactionDropDowns;

    private ReactionType reactionType;
    private ReactionMode reactionMode;
    private ReactionMessage reactionMessage;
    private ReactionMessageType reactionMessageType;
    private ReactionState reactionState;

    public enum ReactionType {
        BUTTON,
        DROPDOWN,
        SLASH,
        EMOJI
    }

    public enum ReactionMode {
        SINGLE_ROLE,
        SINGLE_SELECT,
        SELECT_ONLY,
        UNSELECT_ONLY,
        ROLE_SELECTION
    }

    public enum ReactionMessage {
        SECRET,
        DM,
        NONE,
        PUBLIC
    }

    public enum ReactionMessageType {
        BOT,
        WEBHOOK
    }

    public enum ReactionState {
        ACTIVE,
        INACTIVE
    }

}
