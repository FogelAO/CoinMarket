package fogelao.com.github.coinmarket.entity.api.graph

import com.google.gson.annotations.SerializedName


class GraphResponse(@SerializedName("price_usd") val priceUsd: List<GraphItem>)