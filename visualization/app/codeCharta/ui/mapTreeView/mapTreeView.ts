import angular from "angular";
import "../../core/core.module";
import "../codeMap/codeMap";

import "./mapTreeView.css";

import {mapTreeViewComponent, MapTreeViewController} from "./mapTreeViewComponent";
import {mapTreeViewLevelComponent} from "./mapTreeViewLevelComponent";

angular.module("app.codeCharta.ui.mapTreeView", ["app.codeCharta.core", "app.codeCharta.ui.codeMap"])
    .component(
        mapTreeViewComponent.selector, mapTreeViewComponent
    ).component(
        mapTreeViewLevelComponent.selector, mapTreeViewLevelComponent
    ).directive('ngRightClick', function($parse) {
        return function(scope, element, attrs) {
            let fn = $parse(attrs.ngRightClick);
            element.bind('contextmenu', function(event) {
                scope.$apply(function() {
                    event.preventDefault();
                    fn(scope, {$event:event});
                });
            });
        };
    });