package g.takeru.renshu.leetcode.problems.model

data class Problem (var index: Int,
                    var name: String,
                    var itemClickListener: () -> Unit)