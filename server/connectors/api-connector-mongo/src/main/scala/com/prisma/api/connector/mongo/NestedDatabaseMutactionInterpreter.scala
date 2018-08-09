package com.prisma.api.connector.mongo

import com.prisma.api.connector.mongo.database.{MongoActionsBuilder, SimpleMongoAction}
import com.prisma.api.connector.{DatabaseMutactionResult, UnitDatabaseMutactionResult}
import com.prisma.gc_values.IdGCValue

trait DatabaseMutactionInterpreter {
  protected val unitResult = UnitDatabaseMutactionResult
}

trait TopLevelDatabaseMutactionInterpreter extends DatabaseMutactionInterpreter {

  def mongoAction(mutationBuilder: MongoActionsBuilder): SimpleMongoAction[DatabaseMutactionResult]

}

trait NestedDatabaseMutactionInterpreter extends DatabaseMutactionInterpreter {
  def mongoAction(mutationBuilder: MongoActionsBuilder, parentId: IdGCValue): SimpleMongoAction[DatabaseMutactionResult]
}
