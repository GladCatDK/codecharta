"use strict";

import angular from "angular";

import "./common/common";
import "./fabBar/fabBar";
import "./settingsPanel/index";
import "./revisionChooser/revisionChooser";
import "./legendPanel/legendPanel";
import "./fileChooser/fileChooser.js";
import "./detailPanel/detailPanel";
import "./scenarioButtons/scenarioButtons";
import "./mapTreeView/mapTreeView";
import "./codeMap/codeMap";
import "./metricChooser/metricChooser";
import "./rangeSlider/rangeSlider";
import "./colorSettingsPanel/colorSettingsPanel";
import "./displaySettingsPanel/displaySettingsPanel";

angular.module(
    "app.codeCharta.ui",
    [
        "app.codeCharta.ui.mapTreeView",
        "app.codeCharta.ui.common",
        "app.codeCharta.ui.fabBar",
        "app.codeCharta.ui.settingsPanel",
        "app.codeCharta.ui.revisionChooser",
        "app.codeCharta.ui.legendPanel",
        "app.codeCharta.ui.fileChooser",
        "app.codeCharta.ui.detailPanel",
        "app.codeCharta.ui.scenarioButtons",
        "app.codeCharta.ui.codeMap",
        "app.codeCharta.ui.metricChooser",
        "app.codeCharta.ui.colorSettingsPanel",
        "app.codeCharta.ui.displaySettingsPanel",
        "app.codeCharta.ui.rangeSlider"
    ]);

