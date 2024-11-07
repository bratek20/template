// DO NOT EDIT! Autogenerated by HLA tool

namespace Fishing.Assert {
    export function fishId(given: FishId, expected: string) {
        const diff = diffFishId(given, expected)
        AssertEquals(diff, "", diff)
    }

    export function caughtFish(given: CaughtFish, expected: ExpectedCaughtFish) {
        const diff = diffCaughtFish(given, expected)
        AssertEquals(diff, "", diff)
    }

    export function lure(given: Lure, expected: ExpectedLure) {
        const diff = diffLure(given, expected)
        AssertEquals(diff, "", diff)
    }

    export function fishContent(given: FishContent, expected: ExpectedFishContent) {
        const diff = diffFishContent(given, expected)
        AssertEquals(diff, "", diff)
    }

    export function fishery(given: Fishery, expected: ExpectedFishery) {
        const diff = diffFishery(given, expected)
        AssertEquals(diff, "", diff)
    }
}