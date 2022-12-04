{
  description = "Learning Clojure through Advent of Code 2022";

  inputs = {
    nixpkgs.url = github:NixOS/nixpkgs/release-22.11;
    utils.url = github:numtide/flake-utils;
  };

  outputs = { nixpkgs, utils, ... }:
    utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs { inherit system; };
      in
      rec {
        devShells.default = pkgs.mkShell {
          packages = with pkgs; [
            clojure
            leiningen
          ];
        };
        formatter = pkgs.nixpkgs-fmt;
      }
    );
}
