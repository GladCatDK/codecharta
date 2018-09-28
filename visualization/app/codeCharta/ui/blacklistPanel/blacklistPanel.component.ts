import {Exclude, Settings, SettingsService, SettingsServiceSubscriber} from "../../core/settings/settings.service";
import "./blacklistPanel.component.scss";

export class BlacklistPanelController implements SettingsServiceSubscriber{

    public blacklist: Array<Exclude>;
    public text: string;

    constructor(private settingsService: SettingsService) {
        settingsService.subscribe(this);

        if(settingsService.settings.blacklist) {
            this.blacklist = settingsService.settings.blacklist;
        }
    }

    onChange() {
        this.settingsService.onSettingsChanged();
    }

    onSettingsChanged(settings: Settings, event: Event) {
        if(settings.blacklist) {
            this.blacklist = settings.blacklist;
        }
    }
    removeBlacklistEntry(entry: Exclude){
        console.log("clicked");
        this.settingsService.includeNode(entry);
        this.onChange();
    }
    addBlacklistEntry(){
        this.settingsService.settings.blacklist.push({path: this.text, type: "undefined"});
        this.onChange()
    }

}

export const blacklistPanelComponent = {
    selector: "blacklistPanelComponent",
    template: require("./blacklistPanel.component.html"),
    controller: BlacklistPanelController
};