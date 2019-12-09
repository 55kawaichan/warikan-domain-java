# 飲み会の割勘ドメイン

## 成果物

- チームで設計に合意すること

## 副産物

- ドメインモデル図
    - モデル名を書いた付箋を模造紙に貼る
    - モデル同士の関連を書く
- ドメインオブジェクトの型定義
    - 型名、プロパティ、メソッドの形式が分かればよい
    - 処理を書くことは後回し

## チーム

1チーム最大6名でモブワークしながら進める

## 実装言語

- Java

## 対象ドメイン

飲み会の割勘を、幹事の負担軽減のために、ソフトウェアで解決する

## アクター

- 幹事

## ユースケース

- 幹事が飲み会を開催する(システムの外)
- 幹事が支払区分(多め,普通,少なめ)ごとに支払割合を設定する
- 幹事が開催した飲み会に参加者を追加/削除する
- 幹事が飲み会の請求金額を設定する  
- **幹事が参加者ごとの支払金額を計算する**
    - 割勘の計算方法はチームで相談してください。ただし以下は考慮してください
    - 割勘の方針には、支払金額が多め・普通・少なめを考慮すること(上司は多め、遅く来た人は少なめに金額設定するため)
    - 飲み会の請求金額と割勘した合計支払金額に差額が生じる場合は、システム化対象外してよいです(余裕があるチームは幹事が負担する仕様で検討してください)
        - たとえば、30000円で2人で均等の割勘の場合、1人16666円とすると1円余りが生じます。余り分は幹事で負担するときれいですが仕様外にしてもよいです。あまり細かいところに時間を掛けすぎないようにしましょう。

### 注意事項

- ユースケースに疑問を感じたらいつでも意見や感想を共有しよう。そこからモデルのヒントが得られるかもしれない
- ドメイン上で扱われる情報だけでなく、意味のある計算処理に注目し、最終的にメソッドとして表現すること
- 割勘計算後の実際の支払に関すること。端数金額の支払いの手間はゼロと考えてください。
- HTTPやDB I/Oなどの入出力は一旦忘れましょう

## ドメインモデルの洗い出し(30分)

- ドメインモデルを洗い出し共有する
    - もくもくと考え込まずに声に出す
    - 価値の計算とは何かを考えて説明する(計算式が書けるなら書いてみよう)
    - 思い付いた概念名を付箋に書き出して説明する

以下は一例。他にどんな概念があるか議論してみよう。

|名前(日本語)|英語名(任意)|概要|
|---|----|---|
|飲み会|||
|参加者|||
|支払区分|||
|支払割合|||
|...|||

## ドメインオブジェクトを実装する(30分)

- 概念モデルを実装に反映する
    - 上記で決めた概念名を持つ、具体的な型を定義する。型はクラスでもインターフェイスでもOK
    - プロパティだけではなく、メソッドも仮で定義する
    - 細かい実装は後回し。`return null;` or `throw new NotImplementedException();`などを使うとよい

## ドメインオブジェクトを改善する(45分)

- モデルに対してチームで議論し深いモデルへ改善していく。以下 主な設計や実装の観点
    - モジュール(クラス)の責務を考える
    - プリミティブ型よりドメイン固有型を選択する
    - 不変条件を表明する(型レベル、実行時レベル)
- その場で解決できそうにない問題やリスクについては、赤い付箋でホットスポットとして表現しておく

## 成果物を共有する(15分=3分/チーム*5チーム)

- チーム内でモデルと実装が一致しているかをレビューする
- チームごとに以下を軸に考えたモデルを共有する
    - ドメインモデルの選択と集中
    - 議論が白熱したホットスポット


